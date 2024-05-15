USE [PlayerRank]
GO
/****** Object:  Table [dbo].[PlayerRank]    Script Date: 5/15/2024 11:26:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PlayerRank](
	[playerId] [int] NOT NULL,
	[playerName] [nvarchar](50) NULL,
	[playerScore] [int] NULL,
	[playDate] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[playerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[PlayerRank] ([playerId], [playerName], [playerScore], [playDate]) VALUES (3, N'Zafes', 60, CAST(N'2024-05-04T11:45:16.923' AS DateTime))
GO
INSERT [dbo].[PlayerRank] ([playerId], [playerName], [playerScore], [playDate]) VALUES (4, N'Manh Ha', 32, CAST(N'2024-05-04T11:45:19.907' AS DateTime))
GO
INSERT [dbo].[PlayerRank] ([playerId], [playerName], [playerScore], [playDate]) VALUES (6, N'Zafes', 60, CAST(N'2024-05-04T11:45:19.970' AS DateTime))
GO
INSERT [dbo].[PlayerRank] ([playerId], [playerName], [playerScore], [playDate]) VALUES (7, N'Manh Ha', 32, CAST(N'2024-05-04T12:25:16.457' AS DateTime))
GO
INSERT [dbo].[PlayerRank] ([playerId], [playerName], [playerScore], [playDate]) VALUES (9, N'Zafes', 60, CAST(N'2024-05-04T12:25:16.517' AS DateTime))
GO
